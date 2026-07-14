import Image from "next/image";
import Link from "next/link";

export function Menu(){
    return(
        <main className="mainMenu">
            <nav className="menu">
                <section className="elementosMenu">
                    <Link href = "/">
                        <Image
                            src = "/logo_taskflow.png"
                            width = {100}
                            height = {100}
                            alt = "logo"
                            className="logoApp"
                        />
                    </Link>
                </section>
                <section className="elementosMenu">
                    <Link className="links" href = "/tarefas">
                        <Image
                            src = "/lista-de-tarefas.png"
                            width={100}
                            height={100}
                            alt = "calendario"
                            className="iconeLink"
                        />
                        <h1>Tarefas</h1>
                    </Link>
                </section>
                <section className="elementosMenu">
                    <Link className="links" href = "/calendario">
                        <Image
                            src = "/calendario.png"
                            width={100}
                            height={100}
                            alt = "calendario"
                            className="iconeLink"
                        />
                        <h1>Calendário</h1>
                    </Link>
                </section>
            </nav>
        </main>

        
        
    )
}