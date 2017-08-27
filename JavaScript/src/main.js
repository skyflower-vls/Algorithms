/**
 * Created by viurchuk on 8/10/2017.
 */


main();

function main() {
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
    printArrayToNode(dataToSort, "source_data");
}

/**  @param {Array.<Number>} **/
function initArrayWithData(dataToSort) {
    // create array of data to sort
    for (var i = 0; i < MAX_SIZE; i++) {
        var randomNumber = Math.floor(Math.random() * MAX_RANGE) + 1;
        dataToSort.push(randomNumber);
    }
}