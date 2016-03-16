/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).on("click", "#btnFindDef",
        function () {
            var word = $("#txtWord").val().trim();
            $("#Definition").text(" ");


            $.getJSON("getJSON",
                    {"word": word},
                    function (data) {
                        var defs = data.definitions;

                        if (defs.length == 0) {
                            $("#Definition").append("<br><br><br><br>Definition not found.");
                        } else {
                            var defHTML = "";
                            defHTML += "<br><br><br><br><ol class= 'defList'>";
                            for (var i = 0; i < defs.length; i++) {
                                defHTML += "<li> <strong>(" + defs[i].type + ")</strong> " + defs[i].definition +"</li>";
                            }
                            defHTML += "</ol>";
                            $("#Definition").html(defHTML);
                        }
                    });

        })


