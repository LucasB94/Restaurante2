$(document).ready(function () {
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    function abrirMensagem() {
        swal({
            title: "Ah Não!",
            text: "No momento, não está disponível!",
            icon: "error",
            button: "Voltar",
        });
    }

    function abrirFinalizar() {
        swal({
            title: "Agradecemos pelo cadastro!",
            text: "Desfrute do melhor entretenimento gastronômico!",
            icon: "success",
            button: "Voltar",
        });
    }

    function abrirAgendar() {
        swal({
            title: "Agradecemos pelo agendamento!",
            text: "Estamos ansioso pela tua visita!",
            icon: "success",
            button: "Voltar",
        });
    }
});


