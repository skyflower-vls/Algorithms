/**
 * Created by viurchuk on 8/10/2017.
 */
var insertionSortCheckbox;
var mergeSortCheckbox;
var bubbleSortCheckbox;
var selectionSortCheckbox;
var startAlgorithmsButton;
var shellSortCheckbox;
var quickSortCheckbox;
var quickSort3WayCheckbox;

main();

function main() {
    startAlgorithmsButton = document.getElementById("startAlgorithms");
    startAlgorithmsButton.onclick = onStartButtonClicked;

    var randomItemsNumberInputType = document.getElementById("randomItemsNumberInputType");
    randomItemsNumberInputType.value = MAX_SIZE; //TEMP

    insertionSortCheckbox = document.getElementById("insertionSortCheckbox");
    mergeSortCheckbox = document.getElementById("mergeSortCheckbox");
    bubbleSortCheckbox = document.getElementById("bubbleSortCheckbox");
    selectionSortCheckbox = document.getElementById("selectionSortCheckbox");
    shellSortCheckbox = document.getElementById("shellSortCheckbox");
    quickSortCheckbox = document.getElementById("quickSortCheckbox");
    quickSort3WayCheckbox = document.getElementById("quickSort3WayCheckbox");
}


function onStartButtonClicked() {
    var randomItemsNumberInputType = document.getElementById("randomItemsNumberInputType");
    MAX_SIZE = randomItemsNumberInputType.value;  // TEMP
    var resultsCheckbox = document.getElementById("resultsCheckbox");
    IS_NEED_TO_SHOW_RESULTS = resultsCheckbox.checked; // TEMP

    var dataToSort = new Array();
    initialize(dataToSort);

    // TODO refactor to pattern

    if (insertionSortCheckbox && insertionSortCheckbox.checked) {
        executeAlgorithm(new InsertionSort(), dataToSort);
    } else {
        setEmptyResultsForAlgorithm(ElementIdConst.InsertionSort.SPENT_TIME);
    }

    if (mergeSortCheckbox && mergeSortCheckbox.checked) {
        executeAlgorithm(new MergeSort(), dataToSort);
    } else {
        setEmptyResultsForAlgorithm(ElementIdConst.MergeSort.SPENT_TIME);
    }

    if (bubbleSortCheckbox && bubbleSortCheckbox.checked) {
        executeAlgorithm(new BubbleSort(), dataToSort);
    } else {
        setEmptyResultsForAlgorithm(ElementIdConst.BubbleSort.SPENT_TIME);
    }

    if (selectionSortCheckbox && selectionSortCheckbox.checked) {
        executeAlgorithm(new SelectionSort(), dataToSort);
    } else {
        setEmptyResultsForAlgorithm(ElementIdConst.SelectionSort.SPENT_TIME);
    }

    if (shellSortCheckbox && shellSortCheckbox.checked) {
        executeAlgorithm(new ShellSort(), dataToSort);
    } else {
        setEmptyResultsForAlgorithm(ElementIdConst.ShellSort.SPENT_TIME);
    }

    if (quickSortCheckbox && quickSortCheckbox.checked) {
        executeAlgorithm(new QuickSort(), dataToSort);
    } else {
        setEmptyResultsForAlgorithm(ElementIdConst.QuickSort.SPENT_TIME);
    }

    if (quickSort3WayCheckbox && quickSort3WayCheckbox.checked) {
        executeAlgorithm(new QuickSort3Way(), dataToSort);
        console.log("quickSort3WayCheckbox");
    } else {
        setEmptyResultsForAlgorithm(ElementIdConst.QuickSort3Way.SPENT_TIME);
    }
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
    showNode("source_data", IS_NEED_TO_SHOW_RESULTS);

    if (IS_NEED_TO_SHOW_RESULTS) {
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

function setEmptyResultsForAlgorithm(elementId) {
    var element = document.getElementById(elementId);
    if (element) {
        element.innerHTML = "-";
    }
}
