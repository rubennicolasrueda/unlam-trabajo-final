// messageHandler.js
function displayMessage(type, message) {
    const messageContainer = document.createElement('div');
    messageContainer.className = `alert ${type === 'success' ? 'alert-success' : 'alert-danger'}`;
    messageContainer.innerText = message;

    document.body.prepend(messageContainer);

    // Automatically hide the message after a few seconds
    setTimeout(() => messageContainer.remove(), 5000);
}

async function submitForm(event, formId) {
    event.preventDefault(); // Prevent the default form submission
    const form = document.getElementById(formId);
    const formData = new FormData(form);

    try {
        const response = await fetch(form.action, {
            method: form.method,
            body: formData,
        });

        if (response.ok) {
            displayMessage('success', 'Form submitted successfully!');
            form.reset(); // Clear form on success
        } else {
            displayMessage('error', 'An error occurred while saving the form.');
        }
    } catch (error) {
        displayMessage('error', 'An unexpected error occurred.');
    }
}
