
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns time.parse
    (:require [clj-time.format   :as clj-time.format]
              [mid-fruits.candy  :refer [return]]
              [mid-fruits.map    :as map]
              [mid-fruits.vector :as vector]
              [time.timestamp    :as timestamp]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn parse-date
  ; @param (string) n
  ;
  ; @example
  ;  (time/parse-date "2020-04-20")
  ;  =>
  ;  #<DateTime 2020-04-20T00:00:00.000Z>
  ;
  ; @return (object)
  [n]
  (try (let [formatter (clj-time.format/formatter "yyyy-MM-dd")]
            (clj-time.format/parse formatter n))
       (catch Exception e (println e))))

(defn parse-timestamp
  ; @param (string) n
  ;
  ; @example
  ;  (time/parse-timestamp "2020-04-20T16:20:00.123")
  ;  =>
  ;  #<DateTime 2020-04-20T16:20:00.123Z>
  ;
  ; @return (object)
  [n]
  (try (let [formatter (clj-time.format/formatters :date-time)]
            (clj-time.format/parse formatter n))
       (catch Exception e (println e))))

(defn unparse-timestamp
  ; @param (object) n
  ;
  ; @example
  ;  (time/parse-timestamp #<DateTime 2020-04-20T16:20:00.123Z>)
  ;  =>
  ;  "2020-04-20T16:20:00.123"
  ;
  ; @return (string)
  [n]
  (str n))



;; -- Parse / unparse date and time in data structures ------------------------
;; ----------------------------------------------------------------------------

(defn parse-date-time
  ; @param (*) n
  ;
  ; @example
  ;  (time/parse-date-time {:my-timestamp "2020-04-20T16:20:00.123Z"})
  ;  =>
  ;  {:my-timestamp #<DateTime 2020-04-20T16:20:00.123Z>}
  ;
  ; @return (*)
  [n]
  (cond (timestamp/date-string?      n) (parse-date      n)
        (timestamp/timestamp-string? n) (parse-timestamp n)
        (map?                        n) (map/->values    n parse-date-time)
        (vector?                     n) (vector/->items  n parse-date-time)
        :return n))

(defn unparse-date-time
  ; @param (*) n
  ;
  ; @example
  ;  (time/unparse-date-time {:my-timestamp #<DateTime 2020-04-20T16:20:00.123Z>})
  ;  =>
  ;  {:my-timestamp "2020-04-20T16:20:00.123Z"}
  ;
  ; @return (*)
  [n]
  (cond (timestamp/timestamp-object? n) (unparse-timestamp n)
        (map?                        n) (map/->values      n unparse-date-time)
        (vector?                     n) (vector/->items    n unparse-date-time)
        :return n))
