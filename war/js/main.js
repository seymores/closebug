 

$(document).ready(function() {

    /* Make note draggable */
    $(function() {
        $( "div.note" ).draggable({
            cancel:'p', 
            start:function() {
                $(this).css('z-index', 12);
            }
        })
        
        $( "div.readme" ).resizable();
        
        $("div.note").click(function() {
            var index = $(this).css('z-index');
            console.log(index);
            $("div.note").css('z-index', 10);
            $(this).css('z-index', 11);
            
        });

    });


});

/*
$('.editable').inlineEdit({
    buttonText: 'Add',
    save: function(e, data) {
      return confirm('Change name to '+ data.value +'?');
    }
});
*/

