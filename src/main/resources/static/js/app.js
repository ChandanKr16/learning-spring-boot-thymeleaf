const errorMessage = document.getElementById('errorMessage');
const errorMessageTrigger = document.getElementById('errorMessage');
const options = {
    transition: 'transition-opacity',
    duration: 500,
    timing: 'ease-out',
};



function hideErrorMessage() {
    const dismiss = new Dismiss(errorMessage,  errorMessageTrigger, options);
    dismiss.hide();
}


