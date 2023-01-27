const buttonSubmit = document.querySelector("#buttonSubmit");
const buttonGet = document.querySelector("#buttonGet");
const buttonUpdate = document.querySelector("#buttonUpdate");
const Iname = document.querySelector(".name");
const Islug= document.querySelector(".slug");
const Icity = document.querySelector(".city");
const Istate = document.querySelector(".state");

buttonSubmit.addEventListener("click",function(event){
    event.preventDefault();
    createPlace();
    clean();
});

buttonGet.addEventListener("click",function(event){
    event.preventDefault();
    getPlace();
    clean();
});


buttonUpdate.addEventListener("click",function(event){
    event.preventDefault();
    updatePlace();
    clean();
});

 function createPlace(){
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
    }).then(function(res) {console.log(res)})
    .catch(function(error){console.log(error)})
};

function getPlace(){
    fetch("http://localhost:8080/api/places",
    {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "GET"
    }).then(function(res) {console.log(res)})
    .catch(function(error){console.log(error)})
};


function updatePlace(){
    let place = {};
    place.name = Iname.value;
    place.slug = Islug.value;
    place.city = Icity.value;
    place.state = Istate.value;
    fetch("http://localhost:8080/api/places/123",
    {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "PUT",
        body: JSON.stringify({place})
    }).then(function(res) {console.log(res)})
    .catch(function(error){console.log(error)})
};

function clean(){
    Iname.value = "";
    Islug.value = "";
    Icity.value = "";
    Istate.value = "";
}