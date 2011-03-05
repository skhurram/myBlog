(ns myblog
  (:require [clojure.java.io :as io]))

(def config
  (-> (io/reader (io/resource "myblog/config.clj"))
      (java.io.PushbackReader.)
      (read)))
