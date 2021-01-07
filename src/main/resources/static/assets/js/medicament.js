$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(medicament, status){
           $('#idEdit').val(medicament.id);
           $('#nomMedicamentEdit').val(medicament.nom); 
           $('#dosageMedicMedicamentEdit').val(medicament.dosageMedic); 
           $('#usageMedicMedicamentEdit').val(medicament.usageMedic); 

        });
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(medicament, status){
           $('#idDetail').val(medicament.id);
           $('#nomMedicamentDetail').val(medicament.nom); 
           $('#dosageMedicMedicamentDetail').val(medicament.dosageMedic);
           $('#usageMedicMedicamentDetail').val(medicament.usageMedic);
        });
    $('#detailsModal').modal();
    });
    
    $('table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href=$(this).attr('href');
        
        $('#confirmDeleteButton').attr('href', href);
        
        $('#deleteModal').modal();
        
    });
    
    
});
