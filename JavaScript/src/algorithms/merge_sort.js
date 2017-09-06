/**
 * Created by viurchuk on 8/10/2017.
 */

function MergeSort() {
    /**  @param {Array.<Number>}
     *   @type {Object}
     *   @property {Array.<Number>}
     *   @property {Number}
     * **/
    var algorithm = function (dataArray) {
        var sortedArray = dataArray.slice(0); // clone

        var startedTime = new Date().getTime();

        var result = mergeSort(sortedArray);

        var finishTime = new Date().getTime();
        var timeSpent = finishTime - startedTime;

        return {sortedData: result, timeSpent: timeSpent};
    };

    /**  @param {Array.<Number>} **/
    function mergeSort(array) {
        if (array.length < 2)
            return array;

        var middle = parseInt(array.length / 2);
        var left   = array.slice(0, middle);
        var right  = array.slice(middle, array.length);

        var result =  merge(mergeSort(left), mergeSort(right));
        return result;
    }

    /**  @param {Array.<Number>}
     *   @param {Array.<Number>}
     * **/
    function merge(arrayLeft, arrayRight) {
        var result = [];

        while (arrayLeft.length && arrayRight.length) {
            if (arrayLeft[0] <= arrayRight[0]) {
                result.push(arrayLeft.shift());
            } else {
                result.push(arrayRight.shift());
            }
        }

        while (arrayLeft.length)
            result.push(arrayLeft.shift());

        while (arrayRight.length)
            result.push(arrayRight.shift());

        return result;
    }

    return {
        /**  @param {Array.<Number>}
         *   @type {Object}
         *   @property {Array.<Number>}
         *   @property {Number}
         * **/
        execute: function (dataArray) {
            return algorithm(dataArray);
        },

        /**
         * @param {Object} dataObject
         * param {Array.<Number>}
         * param {Number} time spent for sorting
         */
        writeResult: function (dataObject) {
            var text = dataObject.timeSpent.toString();
            addTextToElementId(text, ElementIdConst.MergeSort.SPENT_TIME);
            emptyNode(ElementIdConst.MergeSort.SORTED_RESULT);
            showNode(ElementIdConst.MergeSort.SORTED_RESULT, IS_NEED_TO_SHOW_RESULTS);
            if (IS_NEED_TO_SHOW_RESULTS) {
                printArrayToNode(dataObject.sortedData, ElementIdConst.MergeSort.SORTED_RESULT);
            }
        }
    }

}
