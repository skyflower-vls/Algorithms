/**
 * Created by viurchuk on 8/10/2017.
 */

/**  @param {Array.<Number>}
 *   @param {String}
 * **/
function printArrayToNode(array, nodeName) {
    var sourceDataDiv = document.getElementById(nodeName);
    for (var i = 0; i < array.length; i++) {
        var text = array[i].toString() + "; ";
        var textNode = document.createTextNode(text);
        sourceDataDiv.appendChild(textNode);
    }
}

/**  @param {String}
 *   @param {String}
 * **/
function addTextToElementId(text, nodeName) {
    var node = document.getElementById(nodeName);
    node.innerHTML += text;
}