$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(articleMedical, status){
           $('#articleMedicalIdEdit').val(articleMedical.articleMedicalId);
           $('#referenceArticleMedicalEdit').val(articleMedical.reference); 
           $('#nomArticleMedicalEdit').val(articleMedical.nom); 
           $('#quantiteArticleMedicalEdit').val(articleMedical.quantite); 

        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(articleMedical, status){
           $('#articleMedicalIdDetail').val(articleMedical.articleMedicalId);
           $('#referenceArticleMedicalDetail').val(articleMedical.reference); 
           $('#nomArticleMedicalDetail').val(articleMedical.nom);
           $('#quantiteArticleMedicalDetail').val(articleMedical.quantite);
        });
    $('#detailsModal').modal();
    });
    
    $('table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href=$(this).attr('href');
        
        $('#confirmDeleteButton').attr('href', href);
        
        $('#deleteModal').modal();
        
    })
    
    
});
