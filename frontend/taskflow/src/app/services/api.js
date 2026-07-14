const API_URL = "http://localhost:8080";

export async function getTarefas () {
    const resp = await fetch(`${API_URL}/tarefas`);

    if(!resp.ok){
        throw new Error("Erro ao buscar tarefa!");
    }

    return resp.json();
}