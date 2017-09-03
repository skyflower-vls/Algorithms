/**
 * Created by viurchuk on 8/10/2017.
 */


main();

function main() {
    var startAlgorithmsButton = document.getElementById("startAlgorithms");
    startAlgorithmsButton.onclick = onStartButtonClicked;
    var randomItemsNumberInputType = document.getElementById("randomItemsNumberInputType");
    randomItemsNumberInputType.value = MAX_SIZE; //TEMP
}


function onStartButtonClicked() {
    var randomItemsNumberInputType = document.getElementById("randomItemsNumberInputType");
    MAX_SIZE = randomItemsNumberInputType.value;  // TEMP
    var resultsCheckbox = document.getElementById("resultsCheckbox");
    IS_NNED_TO_SHOW_RESULTS = resultsCheckbox.checked; // TEMP

    var dataToSort = new Array();
    initialize(dataToSort);

    executeAlgorithm(new InsertionSort(), dataToSort);
    executeAlgorithm(new MergeSort(), dataToSort);
    executeAlgorithm(new BubbleSort(), dataToSort);
    executeAlgorithm(new SelectionSort(), dataToSort);
}

/** @param {function}
 *  @param {Array.<Number>}
 * **/
function executeAlgorithm(command, dataToSort) {
    var resultObj = command.execute(dataToSort);
    command.writeResult(resultObj);
}


/**  @param {Array.<Number>} **/
function initialize(dataToSort) {
    initArrayWithData(dataToSort);

    emptyNode("source_data");
    showNode("source_data", IS_NNED_TO_SHOW_RESULTS);

    if (IS_NNED_TO_SHOW_RESULTS) {
        printArrayToNode(dataToSort, "source_data");
    }
}

/**  @param {Array.<Number>} **/
function initArrayWithData(dataToSort) {
    // create array of data to sort
    for (var i = 0; i < MAX_SIZE; i++) {
        var randomNumber = Math.floor(Math.random() * MAX_RANGE) + 1;
        dataToSort.push(randomNumber);
    }
}