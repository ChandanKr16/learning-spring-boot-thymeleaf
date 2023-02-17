const errorMessage = document.getElementById('errorMessage');
const errorMessageTrigger = document.getElementById('errorMessage');
const deleteButtons = document.getElementsByName("delete-btn");


const options = {
    transition: 'transition-opacity',
    duration: 500,
    timing: 'ease-out',
};

function hideErrorMessage() {
    const dismiss = new Dismiss(errorMessage,  errorMessageTrigger, options);
    dismiss.hide();
}

deleteButtons.forEach(deleteButton => {
    deleteButton.addEventListener('click', (e) =>{
        if(!confirm("Are you sure you want to delete this record?")){
            e.preventDefault();
        }
    });
});

