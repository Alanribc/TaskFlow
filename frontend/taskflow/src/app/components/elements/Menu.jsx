import Image from "next/image";
import Link from "next/link";

export function Menu(){
    return(
        <main className="mainMenu">
            <nav className="menu">
                <section className="elementosMenu">
                    <Image
                        src = "/logo_taskflow.png"
                        width = {100}
                        height = {100}
                        alt = "logo"
                        className="logoApp"
                    />
                </section>
                <section className="elementosMenu">
                    <Link href = "/tarefas"><h1>Tarefas</h1></Link>
                </section>
                <section className="elementosMenu">
                    <Link href = "/calendario"><h1>Calendário</h1></Link>
                </section>
            </nav>
        </main>

        
        
    )
}