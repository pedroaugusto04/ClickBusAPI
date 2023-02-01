const buttonSubmit = document.querySelector("#buttonSubmit");
const buttonGet = document.querySelector("#buttonGet");
const buttonUpdate = document.querySelector("#buttonUpdate");
const buttonGetByName = document.querySelector("#buttonGetName");
const Iname = document.querySelector(".name");
const Islug= document.querySelector(".slug");
const Icity = document.querySelector(".city");
const Istate = document.querySelector(".state");
const responseDiv = document.querySelector(".response");
const text = document.querySelector("#auxText");


buttonSubmit.addEventListener("click",function(event){
    event.preventDefault();
    cleanTable();
    createPlace();
    cleanValues();
});

buttonGet.addEventListener("click",function(event){
    event.preventDefault();
    cleanTable();
    getPlaces();
    cleanValues();
});


buttonUpdate.addEventListener("click",function(event){
    event.preventDefault();
    cleanTable();
    updatePlace();
    cleanValues();
});

buttonGetByName.addEventListener("click",function(event){
    event.preventDefault();
    cleanTable();
    getPlaceByName();
    cleanValues();
})



 function createPlace(){
    addWaitingText();
    if (validateAll()){
        fetch("http://localhost:8080/api/places",
        {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            name: Iname.value,
            slug: Islug.value,
            city: Icity.value,
            state: Istate.value
        })
        })
        .then(response => response.json())
        .then(data => {
            dataText = JSON.stringify(data);
            alert(dataText);
        })
        .catch(error => {
            addWaitingText();
            alert(error);
        })
    } else {
        alert("All fields are required")
        addWaitingText();
    }
};

function getPlaceByName(){
    if (validateName()){
        fetch("http://localhost:8080/api/places/name/" + Iname.value)
        .then(response => response.json())
        .then(data => {
            if (data.length > 0){
                cleanText();
                loadTable(data);    
            } else {
                addWaitingText();
                alert("No data available");
                
            }
        })
        .catch(error => {
            addWaitingText();
            alert(error);
        })  
    } else {
        alert("Name is required");
        addWaitingText();
    }
};

 function getPlaces(){
    fetch("http://localhost:8080/api/places")
    .then(response => response.json())
    .then(data => {
        if (data.length > 0){
            cleanText();
            loadTable(data);    
        } else {
            addWaitingText();
            alert("No data avaliable");
        }
    })
    .catch(error => {
        addWaitingText();
        alert(error)
    })
};


function updatePlace(){
    addWaitingText();
    if (validateAll()){
        let place = {};
        place.name = Iname.value;
        place.city = Icity.value;
        place.state = Istate.value;
        fetch("http://localhost:8080/api/places/" + Islug.value,
        {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "PUT",
        body: JSON.stringify({place})
        })
        .then(response => {
        if (response.status === 204){
            alert(`${response.status}: No Content`);
        } else {
            return response.json();
        }
        })
        .then(data => {
        if(data){
            dataText = JSON.stringify(data);
            alert(dataText); 
        }
        })
        .catch(error => {
            addWaitingText();
            alert(error);
        })  
    } else {
        alert("All fields are required");
        addWaitingText();
    }
};

function loadTable(data){
    const table = document.querySelector("#table");
    table.style.display = "flex";
    for (const place of data){
        const row = table.insertRow();
        const nameCell = row.insertCell(0);
        const slugCell = row.insertCell(1);
        const cityCell = row.insertCell(2);
        const stateCell = row.insertCell(3);
        nameCell.innerHTML = place.name;
        slugCell.innerHTML = place.slug;
        cityCell.innerHTML = place.city;
        stateCell.innerHTML = place.state;    
    }
}

function validateName(){
    if (Iname.value.trim() == ""){
        return false;
    } else {
        return true;
    }
}

function validateAll(){
    if (Iname.value.trim() == "" || Islug.value.trim() == "" || Icity.value.trim() == "" || Istate.value.trim() == ""){
        return false;
    } else {
        return true;
    }
}

function cleanValues(){
    Iname.value = "";
    Islug.value = "";
    Icity.value = "";
    Istate.value = "";
}

function cleanTable(){
    const table = document.querySelector("#table");
    while ( table.rows.length > 1){
        table.deleteRow(1);
    }
}

function addWaitingText(){
    table.style.display = "none";
    text.style.display = "inline-flex";
}

function cleanText(){
    if (text){
        text.style.display = "none";
    }
}