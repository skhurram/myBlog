(defproject myblog "1.0.0-SNAPSHOT"
  :description "My blog"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [compojure "0.5.2"]
                 [ring/ring-jetty-adapter "0.3.1"]
                 [hiccup "0.3.0"]
                 [org.clojars.ato/nailgun "0.7.1"]
                 [org.xerial/sqlite-jdbc "3.6.17"]]
  :dev-dependencies
  [[lein-run "1.0.0-SNAPSHOT"]
   [swank-clojure "1.2.1"]])

