import { Menu } from "@/app/components/elements/Menu";

export default function NovaTarefa(){

    return (
        <main>
            <Menu></Menu>
            <section>

                <h1>Nova tarefa</h1>

                <form className="formAdicionar">

                    <article className="box">
                        <label>Nome da Tarefa</label>
                        <input
                            type="text"
                            placeholder="Digite o título"
                        />
                    </article>
                    
                    <article className="box">
                        <label>Descrição</label>
                        <textarea
                            placeholder="Digite a descrição"
                        />
                    </article>

                    <article className="box">
                        <label>Data e hora</label>
                        <input
                            type="datetime-local"
                            name="dataHora"
                        />
                    </article>

                    <article className="box">
                        <label>Status</label>
                        <select>
                            <option>PENDENTE</option>
                            <option>EM ANDAMENTO</option>
                            <option>CONCLUÍDA</option>
                        </select>
                    </article>

                    <article className="box">
                        <label>Prioridade</label>
                        <select>
                            <option>BAIXA</option>
                            <option>MÉDIA</option>
                            <option>ALTA</option>
                        </select>
                    </article>

                    <article className="submitBotao">
                        <button type="submit">
                            Salvar tarefa
                        </button>
                    </article>
                </form>
            </section>
        </main>
        
    );
}