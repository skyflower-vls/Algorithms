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

        var result = divideArray(sortedArray);

        var finishTime = new Date().getTime();
        var timeSpent = finishTime - startedTime;

        return {sortedData: result, timeSpent: timeSpent};
    };

    /**  @param {Array.<Number>} **/
    function divideArray(array) {
        if (array.length < 2)  return array; // one element has been already sorted

        var halfLen = array.length / 2;
        var leftPartOfArray = array.slice(0, halfLen);
        var rightPartOfArray = array.slice(halfLen, array.length);

        var valueFromLeftPartArray = divideArray(leftPartOfArray);
        var valueFromRightPartArray = divideArray(rightPartOfArray);

        // divide till one element
        // compare all elements from two parts
        return compare(valueFromLeftPartArray, valueFromRightPartArray);
    }

    /**  @param {Array.<Number>}
     *   @param {Array.<Number>}
     * **/
    function compare(arrayLeft, arrayRight) {
        var result = [];

        while(arrayLeft.length || arrayRight.length) {
            if (arrayLeft[0] && arrayRight[0]) {
                if (arrayLeft[0] > arrayRight[0]) {
                    result.push(arrayRight[0]);
                    arrayRight.shift();
                } else {
                    result.push(arrayLeft[0]);
                    arrayLeft.shift();
                }
            }
            else if (arrayLeft[0]) {
                result.push(arrayLeft[0]);
                arrayLeft.shift();
            }
            else if (arrayRight[0]) {
                result.push(arrayRight[0]);
                arrayRight.shift();
            }
        }

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
