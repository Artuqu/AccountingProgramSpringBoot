document.addEventListener("DOMContentLoaded", function () {
        let vat = document.querySelector("#vat");

    vat.addEventListener("change", function () {
        let val;
        let vatValue = vat.value;

        function getVatValue() {
            if (vatValue == 1) {
                val = 1;
            } else if (vatValue == 2) {
                val = 1.05;
            } else if (vatValue == 3) {
                val = 1.08;
            } else if (vatValue == 4) {
                val = 1.23;
            }

            return val
        }

        let netto = document.querySelector("#amountNetto").value;
        let brutto = document.querySelector("#amountBrutto");


        // I changed focus to change
        document.body.addEventListener("change", event=>  {
        if (event.target===vat || event.target===netto){
            let a = brutto.value = (getVatValue() * netto).toFixed(2);
            return a;}
            return a.toFixed(2);
        })



        console.log(getVatValue());
    })



})


