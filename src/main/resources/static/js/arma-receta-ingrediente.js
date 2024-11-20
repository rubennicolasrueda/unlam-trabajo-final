// Keep track of selected ingredients
const selectedIngredients = [];

// Update selected ingredients based on checkboxes
function updateSelectedOptions() {
    selectedIngredients.length = 0; // Clear current selection
    updateSelectedOptionsText()
    document.querySelectorAll("#multiSelectDropdown input[type='checkbox']").forEach(checkbox => {
        if (checkbox.checked) {
            selectedIngredients.push(checkbox.value); // Add checked ingredient to the list
        }
    });

    // Only send the request if two or more ingredients are selected
    if (selectedIngredients.length >= 2) {
        fetchRecipes(selectedIngredients); // Proceed with fetching recipes if condition is met
    }
}

// Función para actualizar la lista de opciones seleccionadas
function updateSelectedOptionsText() {
    var selected = [];
    var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');

    checkboxes.forEach(function(checkbox) {
        selected.push(checkbox.nextElementSibling.innerText); // Obtiene el texto del label asociado al checkbox
    });

    // Muestra las opciones seleccionadas o 'Ninguna' si no hay selección
    document.getElementById("selectedOptions").innerText = selected.length > 0 ? selected.join(' - ') : 'Ninguna';
}

// Fetch recipes from the backend based on selected ingredients
function fetchRecipes(ingredients) {
    fetch(`arma-receta-ingredientes?ingredientes=${encodeURIComponent(ingredients.join(','))}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(data => {
            updateTable(data); // Update the table with the fetched recipes
        })
        .catch(error => console.error("Error fetching recipes:", error));
}

// Update the HTML table with the fetched recipes
function updateTable(recetas) {
    const tableBody = document.querySelector("#recipeTable tbody");
    tableBody.innerHTML = ""; // Clear previous data

    if (recetas.length === 0) {
        tableBody.innerHTML = `<tr><td colspan="4">No hay recetas disponibles</td></tr>`;
    } else {
        recetas.forEach(receta => {
            const row = `
                <tr>
                    <td>${receta.titulo}</td>
                    <td>${receta.descripcion}</td>
                    <td>${receta.valorNutricional}</td>
                    <td>${receta.tipoDeReceta}</td>
                    <td><a onclick="alert('Se implementará próximamente.')" class="btn btn-success">Guardar</a></td>
                </tr>
            `;
            tableBody.innerHTML += row;
        });
    }
}
