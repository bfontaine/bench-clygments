(ns bench-clygments.core
  (:require [clygments.core :as cl]
            [tools.io :as tio]))

(def codebases
  {:git {:path "code/git/"
         :language :c
         :regexp #".+\.[c]$"}

   :jython3 {:path "code/jython3/"
             :language :java
             :skip #{"code/jython3/src/org/python/core/BuiltinDocs.java"}
             :regexp #".+\.java$"}

   :rouge {:path "code/rouge/"
           :language :ruby
           :regexp #".+\.rb$"}
   })

(defn codebase-files
  [{:keys [path regexp skip] :as codebase}]
  (->> (tio/list-files path)
       (filter #(re-matches regexp %))
       (remove (or skip #{}))
       sort
       (mapv (fn [fname] {:name fname :content (slurp fname)}))))

(defn highlight-codebase
  [codebase-name]
  (when-let [{:keys [language] :as codebase} (codebases codebase-name)]
    (doseq [f (codebase-files codebase)]
      (println (:name f))
      (cl/highlight (:content f) language :html))))
