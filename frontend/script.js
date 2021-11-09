function callScript() {

    var country = document.getElementById("country").value;
    var state = document.getElementById("state").value;

    var api_url = "http://localhost:8082/api/customers";
    if (country !== "" && state !== "")
        api_url = api_url.concat("?country=" + country).concat("&state=" + state);
    else if (country !== "")
        api_url = api_url.concat("?country=" + country);
    else if (state !== "")
        api_url = api_url.concat("?state=" + state);

    const response = fetch(api_url).then(response => response.json()).then(data => loadTableData(data));

    function loadTableData(items) {
        const table = document.getElementById("testBody");
        table.innerHTML = '';
        Array.prototype.forEach.call(items, item => {
            let row = table.insertRow();
            let id = row.insertCell(0);
            id.innerHTML = item.id;
            let name = row.insertCell(1);
            name.innerHTML = item.name;
            let phone = row.insertCell(2);
            phone.innerHTML = item.phone;
        });
    }
}