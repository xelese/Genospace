/**
 * This is a java script file that contains functions necessary to hit an api key, parse data from it and display on
 * the html file.
 */

/**
 * This function hits the api to find the drugs and mechanisms, retrieve their names and set it in the html.
 */
async function updateResults() {
    document.getElementById("drugs").innerHTML = "<h1>Drugs</h1>";
    document.getElementById("mechanism").innerHTML = "<h1>Mechanisms</h1>";

    // this is a query contains data that is sent to the api to fetch corresponding results.
    const query = document.getElementById("search1").value;

    // reset the search bar to not have any content visible when there is nothing typed out.
    if (query === "") {
        return
    }

    // This is the response sent to the backend for the query.
    let response = await fetch('http://localhost:8080/find?name=' + query,
        {
            method: 'GET',
            credentials: 'include',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });

    // get the data from the response here from the query.
    data = await response.json();
    var drugs = data[0]
    var mechanism = data[1]
    console.log(drugs)

    // iterate through the drug objects sent from the backend, create a paragraph dynamically and assign the
    // drug id to this paragraph.
    for (var i = 0; i < drugs.length; i++) {
        var para = document.createElement("p");
        para.style.margin = "50px";
        para.id = drugs[i].id

        // when clicked the paragraph hit the api to find the drug by id.
        para.onclick = function () {
            showDrugInfo(this.id)
        }

        var node = document.createTextNode(drugs[i].nameMain);
        para.appendChild(node);

        var element = document.getElementById("drugs");
        element.appendChild(para);
    }

    // iterate through the mechanism objects sent from the backend, create a paragraph dynamically and assign the
    // mechanism id to this paragraph.
    for (var i = 0; i < mechanism.length; i++) {
        var para = document.createElement("p");
        para.style.margin = "50px";
        para.id = mechanism[i].id

        // when clicked the paragraph hit the api to find the drug by id.
        para.onclick = function () {
            showMechanismInfo(this.id)
        }

        var node = document.createTextNode(mechanism[i].name);
        para.appendChild(node);

        var element = document.getElementById("mechanism");
        element.appendChild(para);
    }

}

/**
 * This function assigns drug data received from the backed to the info div in the html. the api key hit here gives us
 * full details of the corresponding drug.
 * @param id Drug id that is used to query the backend using /find/drug/{id} api.
 * @returns {Promise<void>} all drug details.
 */
async function showDrugInfo(id) {
    var info = document.getElementById("info")

    // hit the api key and fetch the drug data to be displayed.
    response = await fetch('http://localhost:8080/find/drug/' + id, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    // get the data and set the inner text of the info div as this drug data.
    data = await response.json();
    data = JSON.stringify(data)
    info.innerText = data
}

/**
 * his function assigns all the drugs received from the backed to the info div in the html. the api key hit here gives
 * us list of all the drugs that have this mechanism.
 * @param id Drug id that is used to query the backend using /find/drug/{id} api.
 * @returns {Promise<void>} all drug details.
 */
async function showMechanismInfo(id) {
    var info = document.getElementById("info")
    response = await fetch('http://localhost:8080/find/mechanism/' + id, {
        method: 'GET',
        credentials: 'include',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    // get the data and set the inner text of the info div as this drug data.
    data = await response.json();
    data = JSON.stringify(data)
    info.innerText = data
}