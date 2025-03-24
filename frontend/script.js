 document.addEventListener("DOMContentLoaded", () => {
            const driverTableBody = document.querySelector("#driverTable tbody");

            // Fetch data from API
            async function fetchDriverData() {
                try {
                    const response = await fetch("http://localhost:8080/DriverDetails"); // Replace with your API endpoint
                    if (!response.ok) {
                        throw new Error("Failed to fetch data from the server.");
                    }

                    const driverData = await response.json();
                    populateDriverTable(driverData);
                } catch (error) {
                    console.error("Error fetching data:", error);
                }
            }

            // Populate table with fetched data
            function populateDriverTable(data) {
                driverTableBody.innerHTML = ""; // Clear existing rows
                data.forEach(item => {
                    const row = document.createElement("tr");

                    row.innerHTML = `
                        <td>${item.driverName}</td>
                        <td>${item.licenseNumber}</td>
                        <td>${item.phoneNumber}</td>
                        <td>
                            <button class="edit-btn" data-id="${item.id}">Edit</button>
                            <button class="delete-btn" data-id="${item.id}">Delete</button>
                        </td>
                    `;

                    driverTableBody.appendChild(row);
                });
            }

            // Initialize the data fetch
            fetchDriverData();
        });