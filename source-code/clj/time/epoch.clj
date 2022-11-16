
(ns time.epoch
    (:require [clj-time.coerce :as clj-time.coerce]
              [clj-time.core   :as clj-time.core]
              [time.converters :as converters]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms
  ; @return (ms)
  []
  (-> (clj-time.core/now)
      (clj-time.coerce/to-long)))

(defn epoch-s
  ; @return (s)
  []
  (-> (clj-time.core/now)
      (clj-time.coerce/to-long)
      (quot 1000)))

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
  (if n (-> n converters/s->ms clj-time.coerce/from-long str)))
