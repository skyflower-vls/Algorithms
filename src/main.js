/**
 * Created by viurchuk on 8/10/2017.
 */


main();

function main() {
    var dataToSort = new Array();

    initialize(dataToSort);

    executeAlgorithm(AlgorithmNamesConst.INSERTION, dataToSort);
    executeAlgorithm(AlgorithmNamesConst.MERGE, dataToSort);
    executeAlgorithm(AlgorithmNamesConst.BUBBLE, dataToSort);
}

/** @param {string}
 *  @param {Array.<Number>}
 * **/
function executeAlgorithm(name, dataToSort) {
    var resultObj = null;
    switch (name) {
        case AlgorithmNamesConst.INSERTION:
            var command = new InsertionSort();
            resultObj = command.execute(dataToSort);
            command.writeResult(resultObj);
            break;

        case AlgorithmNamesConst.MERGE:
            var command = new MergeSort();
            resultObj = command.execute(dataToSort);
            command.writeResult(resultObj);
            break;

        case AlgorithmNamesConst.BUBBLE:
            var command = new BubbleSort();
            resultObj = command.execute(dataToSort);
            command.writeResult(resultObj);
            break;
    }
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