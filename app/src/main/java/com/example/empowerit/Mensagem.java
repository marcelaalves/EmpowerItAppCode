package com.example.empowerit;

/**
 * Created by Marcela on 23/08/15.
 */
public class Mensagem<T> {

    /* TODO Desvincular mensagem do login
	 *  - Os mÃ©todos desta classe devem ser genÃ©ricos para toda tarefa
	 *  	assincrona que precisar se comunicar atravÃ©s com UI
	 */

    /* constantes para Login*/ //TODO Colocar essas strings no strings.xml
    private static final String SUCESSO_LOGIN = "Login efetuado com sucesso.";
    private static final String FALHA_LOGIN = "Falha durante o processo de Login.";

    private long id;
    private int progressoTarefa;
    private StatusTarefa status;
    private String mensagem;
    private T anexo;


    /**
     * Gera uma mensagem de sucesso para a tarefa de Login (LoginTask).
     *
     * @param usuario
     *            nome de usuÃ¡rio (login)
     * @param senha
     *            senha do usuÃ¡rio
     * @param token
     *            token gerado pelo serviÃ§o REST de login
     * @return Uma mensagem contendo o status de sucesso para o processo de
     *         login, mensagem de sucesso e o objeto Credential com os dados do
     *         usuÃ¡rio.
     */
    public static Mensagem<Credential> sucessoLogin(String usuario,
                                                    String senha, String token) {

        Mensagem<Credential> m = new Mensagem<Credential>();
        m.status = StatusTarefa.HTTP_200;
        m.mensagem = SUCESSO_LOGIN;

        Credential c = new Credential(usuario, senha);
        m.anexo = c;

        return m;
    }


    public static Mensagem<Credential> sucessoLogin(Credential credential) {

        Mensagem<Credential> m = new Mensagem<Credential>();
        m.status = StatusTarefa.HTTP_200;
        m.mensagem = SUCESSO_LOGIN;

        m.anexo = credential;

        return m;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Mensagem<Credential> falhaLogin(boolean erroLogin, boolean erroSenha){

        Mensagem m = new Mensagem();
        m.status = StatusTarefa.HTTP_400;
        m.mensagem = FALHA_LOGIN;
        return m;

    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public T getAnexo() {
        return anexo;
    }

    public void setAnexo(T anexo) {
        this.anexo = anexo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getProgressoTarefa() {
        return progressoTarefa;
    }

    public void setProgressoTarefa(int progressoTarefa) {
        this.progressoTarefa = progressoTarefa;
    }

}
