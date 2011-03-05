(ns myblog.core
  (:use ring.adapter.jetty
        [myblog.web :only [main-routes]])
  ;(:require clojars.scp)
  (:import com.martiansoftware.nailgun.NGServer
           java.net.InetAddress)
  );(:gen-class)

#_(defn -main [& [http-port ng-port]]
  (if (not (and http-port ng-port))
    (do (.println System/err "Usage: clojars.core http-port nailgun-port")
        (.println System/err "   eg: clojars.core 8080 8701"))
    (do
      (println "clojars-web: starting jetty on port" http-port)
      (run-jetty clojars-app {:port (Integer/parseInt http-port) :join? false})
      (println "clojars-web: starting nailgun on 127.0.0.1 port " ng-port)
      (.run (NGServer. (InetAddress/getByName "127.0.0.1")
                       (Integer/parseInt ng-port))))))

;;(defonce server (run-jetty #'main-routes {:port 8085 :join? false}))

(future (run-jetty (var main-routes) {:port 8080}))
