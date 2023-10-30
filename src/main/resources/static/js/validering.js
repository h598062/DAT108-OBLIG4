function validering () {
    let fornavnElm = document.getElementById("fornavn");
    let etternavnElm = document.getElementById("etternavn");
    let mobilElm = document.getElementById("mobil");
    let passordElm = document.getElementById("passord");
    let passordRepetertElm = document.getElementById("passordRepetert");

    fornavnElm.setCustomValidity("");
    etternavnElm.setCustomValidity("");
    mobilElm.setCustomValidity("");
    passordElm.setCustomValidity("");
    passordRepetertElm.setCustomValidity("");

    fornavnElm.checkValidity();
    etternavnElm.checkValidity();
    mobilElm.checkValidity();
    passordElm.checkValidity();
    passordRepetertElm.checkValidity();

    let fornavn = fornavnElm.value;
    let etternavn = etternavnElm.value;
    let mobil = mobilElm.value;
    let passord = passordElm.value;
    let passordRepetert = passordRepetertElm.value;

    let fornavnRegex = /^[\p{L} -]+$/u;
    let etternavnRegex = /^[\p{L}-]+$/u;
    let mobilRegex = /^[0-9]+$/;

    if (fornavn.length < 2 || fornavn.length > 20) {
        fornavnElm.setCustomValidity("Fornavn må være minst 2 tegn, og maks 20 tegn");
    } else if (!fornavnRegex.test(fornavn)) {
        fornavnElm.setCustomValidity("Fornavn kan kun inneholde bokstaver, bindestrek og mellomrom");
    }
    if (etternavn.length < 2 || etternavn.length > 20) {
        etternavnElm.setCustomValidity("Etternavn må være minst 2 tegn, og maks 20 tegn");
    } else if (!etternavnRegex.test(etternavn)) {
        etternavnElm.setCustomValidity("Etternavn kan kun inneholde bokstaver og bindestrek");
    }
    if (mobil.length !== 8) {
        mobilElm.setCustomValidity("Mobilnummer må være 8 siffer");

    } else if (!mobilRegex.test(mobil)) {
        mobilElm.setCustomValidity("Mobilnummer kan kun inneholde tall");
    }

    if (passord.length < 5) {
        passordElm.setCustomValidity("Passord må være minst 5 tegn");
    }
    if (passord !== passordRepetert) {
        passordRepetertElm.setCustomValidity("Passordene må være like");
    }

}

let submitbtn = document.getElementById("submit-btn");
submitbtn.addEventListener("click", validering);
