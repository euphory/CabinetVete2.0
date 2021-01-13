$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(facture, status){
           $('#idFactureEdit').val(facture.idFacture);
           $('#dateFactureEdit').val(facture.date); 
           $('#modeReglementFactureEdit').val(facture.modeReglement); 
           $('#dateReglementFactureEdit').val(facture.dateReglement);
           $('#totalFactureEdit').val(facture.total);
           $('#totalTTCFactureEdit').val(facture.totalTTC);

        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(facture, status){
           $('#idFactureDetail').val(facture.idFacture);
           $('#dateFactureDetail').val(facture.date); 
           $('#modeReglementFactureDetail').val(facture.modeReglement);
           $('#dateReglementFactureDetail').val(facture.dateReglement);
           $('#totalFactureDetail').val(facture.total);
           $('#totalTTCFactureDetail').val(facture.totalTTC);
        });
    $('#detailsModal').modal();
    });
document.getElementById("aujourdhui").valueAsDate = new Date();
    $('table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href=$(this).attr('href');
        
        $('#confirmDeleteButton').attr('href', href);
        
        $('#deleteModal').modal();
        
    })
    
    
});
