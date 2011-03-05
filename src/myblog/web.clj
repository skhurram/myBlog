(ns myblog.web
  (:require [clojure.contrib.sql :as sql])
  (:use [hiccup.core])
  (:use [compojure.core]))

(defn not-found-doc []
  (html [:h1 "Page not found"]
        [:p "Thundering typhoons!  I think we lost it.  Sorry!"]))


(defn home-page []
  (html [:h1 "My Blog"]
        [:p "Welcome to My Blog!"]))


(defmacro with-account [body]
  `(if-let [~'account (~'session :account)]
     (do ~body)
     (redirect "/login")))

(defmacro try-account [body]
  `(let [~'account (~'session :account)]
     (do ~body)))

(defroutes main-routes
  (GET "/" {session :session params :params} (home-page))
  (ANY "*" {session :session}
    (html-d)))

                                        ;(require 'swank.swank)
                                        ;(swank.swank/start-server "/dev/null" :port 4005)


                                        ;(use 'clojure.contrib.repl-utils)
                                        ;(show server)
                                        ;(.stop server)

                                        ;(with-db (find-jar "leiningen"))


                                        ;(def server (run-server {:port 8000} "/*" (servlet clojars-app)))
