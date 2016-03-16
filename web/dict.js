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
                        $("#Definition").append("<br><br><br><br><dl>");
                        if(defs.length==0){
                            
                        }
                        for (var i = 0; i < defs.length; i++) {
                            console.log(defs[i]);
                            $("#Definition").append("<dt>" + defs[i].type + "</dt>");
                            $("#Definition").append("<dd>" + defs[i].definition + "</dd>");

                        }
                        $("#Definition").append("</dl>");
                    });

        })


