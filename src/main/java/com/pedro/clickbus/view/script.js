const buttonSubmit = document.querySelector("#buttonSubmit");
const buttonGet = document.querySelector("#buttonGet");
const buttonUpdate = document.querySelector("#buttonUpdate");
const buttonGetByName = document.querySelector("#buttonGetName");
const Iname = document.querySelector(".name");
const Islug= document.querySelector(".slug");
const Icity = document.querySelector(".city");
const Istate = document.querySelector(".state");
const responseDiv = document.querySelector(".response");


buttonSubmit.addEventListener("click",function(event){
    event.preventDefault();
    createPlace();
    clean();
});

buttonGet.addEventListener("click",function(event){
    event.preventDefault();
    getPlaces();
    clean();
});


buttonUpdate.addEventListener("click",function(event){
    event.preventDefault();
    updatePlace();
    clean();
});

buttonGetByName.addEventListener("click",function(event){
    event.preventDefault();
    getPlaceByName();
    clean();
})



 function createPlace(){
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
        responseDiv.textContent = dataText;
    })
    .catch(error => console.log(error))
    } else {
        alert("All fields are required")
    }
};

function getPlaceByName(){
    if (validateName()){
        fetch("http://localhost:8080/api/places/name/" + Iname.value)
        .then(response => response.json())
        .then(data => {
            dataText = JSON.stringify(data);
            responseDiv.textContent = dataText;
        })
        .catch(error => console.log(error))  
    } else {
        alert("Name is required");
    }
};

 function getPlaces(){
    fetch("http://localhost:8080/api/places")
    .then(response => response.json())
    .then(data => {
        dataText = JSON.stringify(data);
        responseDiv.textContent = dataText;
    })
    .catch(error => console.log(error))
};


function updatePlace(){
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
            responseDiv.textContent = `${response.status}: No Content`;
        } else {
            return response.json();
        }
        })
        .then(data => {
        if(data){
            dataText = JSON.stringify(data);
            responseDiv.textContent = dataText;  
        }
        })
        .catch(error => console.log(error))  
    } else {
        alert("All fields are required");
    }
};

function clean(){
    Iname.value = "";
    Islug.value = "";
    Icity.value = "";
    Istate.value = "";
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


function format(dataText){
    //
}
