
(ns time.epoch
    (:require [string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms
  ; @usage
  ; (epoch-ms)
  ;
  ; @return (ms)
  [])
  ; TODO

(defn epoch-s
  ; @usage
  ; (epoch-s)
  ;
  ; @return (s)
  [])
  ; TODO

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
  [n])
  ; TODO

(defn epoch-s->timestamp-string
  ; @param (s) n
  ;
  ; @example
  ; (epoch-s->timestamp-string 1640800860)
  ; =>
  ; "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n])
  ; TODO

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
  [n])
  ; TODO

(defn timestamp-string->epoch-s
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->epoch-s "2021-12-29T18:01:00.000Z")
  ; =>
  ; 1640800860
  ;
  ; @return (s)
  [n])
  ; TODO

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
  ; @param (ms) epoch-ms
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
  [epoch-ms]
  (-> epoch-ms epoch-ms->timestamp-string (string/part 0 10)))
