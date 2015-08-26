package com.example.empowerit;

/**
 * Created by Marcela on 23/08/15.
 */
public enum StatusTarefa {

        DOWNLOAD_CONCLUIDO(1),
        PROGRESSO_DOWNLOAD(2),
        FALHA_DOWNLOAD(3),
        EXCECAO(4),
        INDEFINIDO(5),
        DOWNLOAD_CANCELADO(6),

        HTTP_200(200), // sucesso
        HTTP_400(400), // erro
        HTTP_401(401) ;

        private final int status;

        StatusTarefa(int status) {
            this.status = status;
        }

        public int getStatus() { return status; }

        public static StatusTarefa valueOf(int status){

            for(StatusTarefa st : values()){
                if(st.getStatus() == status)
                    return st;
            }

            return INDEFINIDO;
        }

    }
