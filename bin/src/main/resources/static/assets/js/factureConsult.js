$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(factureConsult, status){
           $('#idFactureConsultEdit').val(factureConsult.idFactureConsult);
           $('#dateFactureConsultEdit').val(factureConsult.date); 
           $('#modeReglementFactureConsultEdit').val(factureConsult.modeReglement); 
           $('#dateReglementFactureConsultEdit').val(factureConsult.dateReglement);
           $('#totalFactureConsultEdit').val(factureConsult.total);


        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(factureConsult, status){
           $('#idFactureConsultDetail').val(factureConsult.idFactureConsult);
           $('#dateFactureConsultDetail').val(factureConsult.date); 
           $('#modeReglementFactureConsultDetail').val(factureConsult.modeReglement);
           $('#dateReglementFactureConsultDetail').val(factureConsult.dateReglement);
           $('#totalFactureConsultDetail').val(factureConsult.total);
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
