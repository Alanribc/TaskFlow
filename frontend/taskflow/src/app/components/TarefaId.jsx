export async function TarefaId (id) {
    try{
        const url = `http://localhost:8080/tarefas/id`;
        const resp = await fetch(url);
        const json = await resp.json();

        if (json.success == false | json.status_code){
            return null;
        }
        
        return json;
    } catch(error){
        return null;
    }
}