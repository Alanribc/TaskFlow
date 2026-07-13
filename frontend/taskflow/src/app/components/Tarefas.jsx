import { Tarefa } from "./Tarefa";

export async function Tarefas (){
    try{
        const resp = await fetch ("http:localhost:8080/tarefas");
        const tarefas = await resp.json();

        if(json.errors | json.success == false){
            return {tarefas : [], erro: "Tarefa não encontrada."}
        } else{
            return (
                <section>
                    {tarefas && tarefas.map((tarefa) => {
                        return <Tarefa {...tarefa}></Tarefa>
                    })}
                </section>
            )
        }
    }catch (error){
        return {tarefas: [], erro: "Erro na busca."}
    }
} 