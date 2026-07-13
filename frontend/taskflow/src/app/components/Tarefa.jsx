export function Tarefa ({id, titulo, descricao, dataHora, status, prioridade, criadoEm, atualizadoEm, concluidoEm}) {
    return(
        <section className="tarefa">
            <h1>{titulo}</h1>
            <p>{descricao}</p>
        </section>    
    )
}