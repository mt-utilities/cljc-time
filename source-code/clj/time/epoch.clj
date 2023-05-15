
(ns time.epoch
    (:require [clj-time.coerce  :as clj-time.coerce]
              [clj-time.core    :as clj-time.core]
              [iso.time.convert :as convert]
              [string.api       :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms
  ; @usage
  ; (epoch-ms)
  ;
  ; @return (ms)
  []
  (-> (clj-time.core/now)
      (clj-time.coerce/to-long)))

(defn epoch-s
  ; @usage
  ; (epoch-s)
  ;
  ; @return (s)
  []
  (-> (clj-time.core/now)
      (clj-time.coerce/to-long)
      (quot 1000)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms->timestamp-string
  ; @param (ms) n
  ;
  ; @example
  ; (epoch-ms->timestamp-string 1640800860000)
  ; =>
  ; "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n]
  (if n (-> n clj-time.coerce/from-long str)))

(defn epoch-s->timestamp-string
  ; @param (s) n
  ;
  ; @example
  ; (epoch-s->timestamp-string 1640800860)
  ; =>
  ; "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n]
  (if n (-> n convert/s->ms clj-time.coerce/from-long str)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->epoch-ms
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->epoch-ms "2021-12-29T18:01:00.000Z")
  ; =>
  ; 1640800860000
  ;
  ; @return (ms)
  [n]
  (if n (-> n clj-time.coerce/to-epoch convert/s->ms)))

(defn timestamp-string->epoch-s
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->epoch-s "2021-12-29T18:01:00.000Z")
  ; =>
  ; 1640800860
  ;
  ; @return (s)
  [n]
  (if n (-> n clj-time.coerce/to-epoch)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-object->epoch-ms
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-object->epoch-ms #<DateTime 2021-12-29T18:01:00.000+02:00>)
  ; =>
  ; 1640800860000
  ;
  ; @return (ms)
  [n]
  (if n (-> n str clj-time.coerce/to-epoch convert/s->ms)))

(defn timestamp-object->epoch-s
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-object->epoch-s #<DateTime 2021-12-29T18:01:00.000+02:00>)
  ; =>
  ; 1640800860
  ;
  ; @return (s)
  [n]
  (if n (-> n str clj-time.coerce/to-epoch)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn date->epoch-ms
  ; @description
  ; Converts the given date to timestamp-string than converts the result to epoch-ms.
  ;
  ; @param (string) date
  ;
  ; @usage
  ; (date->epoch-ms "2020-04-20")
  ;
  ; @example
  ; (date->epoch-ms "2020-04-20")
  ; =>
  ; 1587340800000
  ;
  ; @return (ms)
  ; The very first millisec of the given date.
  [date]
  (-> date (str "T00:00:00.000Z") timestamp-string->epoch-ms))

(defn epoch-ms->date
  ; @ignore
  ;
  ; @description
  ; Converts the given date to timestamp-string than converts the result to epoch-ms.
  ;
  ; @param (ms) start-ms
  ;
  ; @usage
  ; (epoch-ms->date 1587340800000)
  ;
  ; @example
  ; (epoch-ms->date 1587340800000)
  ; =>
  ; "2020-04-20"
  ;
  ; @return (string)
  ; The date of the given millisec.
  [start-ms]
  (-> start-ms epoch-ms->timestamp-string (string/part 0 10)))
