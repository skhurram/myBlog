(ns myblog.web
  (:require [clojure.contrib.sql :as sql])
  (:use [hiccup.core])
  (:use [compojure.core])
  (:use [compojure.route :as route]))

(defn not-found-doc []
  (html [:h1 "Page not found"]
        [:p "Thundering typhoons!  I think we lost it.  Sorry!"]))


(defn home-page []
  (html [:h1 "My Blog"]
        [:p "Welcome to My Blog! Updated"]))

(defn page-not-found []
  (html
   [:head
    [:title "My Blog"]]
   [:body 
    [:h1 "My Blog"]
    [:p "Page not found"]]))


(defmacro with-account [body]
  `(if-let [~'account (~'session :account)]
     (do ~body)
     (redirect "/login")))

(defmacro try-account [body]
  `(let [~'account (~'session :account)]
     (do ~body)))

(defroutes main-routes
  (GET "/" {session :session params :params} (home-page))
  (route/not-found  (page-not-found)))

                                        ;(require 'swank.swank)
                                        ;(swank.swank/start-server "/dev/null" :port 4005)


                                        ;(use 'clojure.contrib.repl-utils)
                                        ;(show server)
                                        ;(.stop server)

                                        ;(with-db (find-jar "leiningen"))


                                        ;(def server (run-server {:port 8000} "/*" (servlet clojars-app)))
