const fetchTodos = async () => {
  try {
    const response = await fetch('https://dummyjson.com/todos');
    const data = await response.json();
    const todos = data.todos;

    const tableBody = document.querySelector('#todosTable tbody');

    todos.forEach(todo => {
      const row = document.createElement('tr');

      row.innerHTML = `
        <td>${todo.id}</td>
        <td>${todo.todo}</td>
        <td>${todo.completed ? 'done' : 'not done'}</td>
        <td>${todo.userId}</td>
      `;

      tableBody.appendChild(row);
    });
  } catch (error) {
    console.error('Failed to fetch todos:', error);
  }
};

fetchTodos();
