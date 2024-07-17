function openTab(evt, tenTab) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tenTab).style.display = "block";
    evt.currentTarget.className += " active";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

let arraysize = new Array();
function addSize(tenIdForm, htSize, sizeInput, tenMang) {
    let kichthuoc = document.getElementById(htSize);
    let input = document.getElementById(sizeInput);
    // creating checkbox element
    let nutsize = document.createElement('button');
    // Assigning the attributes to created checkbox
    if (input.value != "") {
        let giatri = input.value;
        nutsize.className = "btnsize";
        nutsize.type = "button";
        nutsize.id = "nuttam";
        nutsize.appendChild(document.createTextNode(giatri));
        arraysize.push(giatri);
        document.getElementById(tenMang).value = arraysize;
        // appending the checkbox and label to div
        kichthuoc.appendChild(nutsize);
        input.value = "";
        document.getElementById(tenIdForm).style.display = 'none';
    }
    else alert("phải nhập kích thước mới thêm size được!");
    // myDiv.appendChild(label);
}
function closeSize(tenId, sizeInput){
    document.getElementById(tenId).style.display = 'none';
    let input = document.getElementById(sizeInput);
    if(input.value != ""){
        input.value="";
    }
}

function closeformThem(tenId) {
    document.getElementById(tenId).style.display = 'none';
    document.querySelectorAll('#nuttam').forEach(element => {
        element.remove();
    });
    arraysize = new Array();
}

document.querySelectorAll('[name="arraySize"]').forEach(element =>{
    element.style.display = 'none';
});