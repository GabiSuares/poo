import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partida {
    private final Time time1;
    private final Time time2;
    private final Time vencedor;
    private static final List<Partida> historico = new ArrayList<>();
    private static final Map<Time, List<String>> resultadosPorTime = new HashMap<>();

    public Partida(Time time1, Time time2, Time vencedor) {
        this.time1 = time1;
        this.time2 = time2;
        this.vencedor = vencedor;
        registrarResultado();
    }
    private void registrarResultado() {
    if (vencedor != null) {
        vencedor.adicionarPontuacao(3);
        historico.add(this);
        registrarResultadoParaTime(time1, time1 == vencedor ? "Venceu" : "Perdeu");
        registrarResultadoParaTime(time2, time2 == vencedor ? "Venceu" : "Perdeu");
        }
    }

    private void registrarResultadoParaTime(Time time, String resultado) {
        resultadosPorTime
        .computeIfAbsent(time, t -> new ArrayList<>())
        .add(getAdversario(time).getNome() + " - " + resultado);
    }
    public static List<Partida> getHistorico() {
        return historico;
    }
    public static List<String> getResultadosDoTime(Time time) {
        return resultadosPorTime.getOrDefault(time, new ArrayList<>());
    }
    public Time getAdversario(Time time) {
        return time == time1 ? time2 : time1;
    }
    public Time getTime1() {
        return time1;
    }
    public Time getTime2() {
        return time2;
    }
    public Time getVencedor() {
        return vencedor;
    }
}
