var main = {
    init : function (){
        var _this = this;
        $('#btn-update').on('click',function (){
            _this.update();
        });

    },
    update : function (){
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };
        var id = $('#id').val();
        $.ajax({
            type:'PUT',
            url: '/api/post/'+id,
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data:JSON.stringify(data)
        }).done(function (){
            alert('글이 수정 되었습니다.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};
main.init();