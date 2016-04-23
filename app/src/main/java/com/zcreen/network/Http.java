package com.zcreen.network;

/**
 * Created by mertkanuzunparmak on 23/02/16.
 * mertkan@mobilike.com
 */
public class Http {

    public class Header {

        public class Field {

            public static final String USER_AGENT = "User-Agent";
            //TODO Add required header fields here!
        }
    }

    /**
     * For more information, see:
     *
     *   http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
     */
    public static class Status {

        public static class Code {

            public static final int OK = 200;

            /**
             * @param code Http response status code
             * @return If given status code belongs to informal category, true. Otherwise, false.
             */
            public static boolean isInformal(int code) {
                return (code >= 100) && (code < 200);
            }

            /**
             * @param code Http response status code
             * @return If given status code belongs to success category, true. Otherwise, false.
             */
            public static boolean isSuccess(int code) {
                return (code >= 200) && (code < 300);
            }

            /**
             * @param code Http response status code
             * @return If given status code belongs to redirection category, true. Otherwise, false.
             */
            public static boolean isRedirection(int code) {
                return (code >= 300) && (code < 400);
            }

            /**
             * @param code Http response status code
             * @return If given status code belongs to client-error category, true. Otherwise, false.
             */
            public static boolean isClientError(int code)
            {
                return (code >= 400) && (code < 500);
            }

            /**
             * @param code Http response status code
             * @return If given status code belongs to server-error category, true. Otherwise, false.
             */
            public static boolean isServerError(int code)
            {
                return (code >= 500) && (code < 600);
            }
        }
    }
}
