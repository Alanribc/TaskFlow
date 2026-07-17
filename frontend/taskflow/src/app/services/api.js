const API_URL = process.env.NEXT_PUBLIC_API_URL;

console.log(API_URL);

export async function getTarefas () {
    const resp = await fetch(`${API_URL}/tarefas`);

    if(!resp.ok){
        throw new Error("Erro ao buscar tarefa!");
    }

    return resp.json();
}

export async function getTarefaByID(id) {
    const resp = await fetch(`${API_URL}/tarefas/${id}`);
        
    if(!resp.ok){
        throw new Error("Erro ao buscar tarefa!");
    }

    return resp.json();
}

export async function criarTarefa(tarefa) {
    const resp = await fetch(`${API_URL}/tarefas`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(tarefa),
    });

    return resp.json();
}

export async function atualizarTarefa(id, tarefa) {
    await fetch(`${API_URL}/tarefas/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(tarefa),
    });
}

export async function deletarTarefa(id) {
    await fetch(`${API_URL}/tarefas/${id}`, {
        method: "DELETE",
    });
}