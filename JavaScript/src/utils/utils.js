/**
 * Created by viurchuk on 8/10/2017.
 */

/**  @param {Array.<Number>}
 *   @param {String}
 * **/
function printArrayToNode(array, nodeName) {
    var sourceDataDiv = document.getElementById(nodeName);
    sourceDataDiv.innerHTML = "";

    while (sourceDataDiv.hasChildNodes()) {
        sourceDataDiv.removeChild(sourceDataDiv.lastChild);
    }

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
    node.innerHTML = "";
    node.innerHTML = text;
}

function showNode(nodeName, isVisible) {
    var node = document.getElementById(nodeName);
    if (isVisible) {
        node.style.visibility = "visible";
    } else {
        node.style.visibility = "hidden";
    }
}

function emptyNode(nodeName) {
    var node = document.getElementById(nodeName);
    node.innerHTML = "";
}