
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns time.epoch
    (:require [time.converters :as converters]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms
  ; @return (ms)
  [])
  ; TODO

(defn epoch-s
  ; @return (s)
  [])
  ; TODO

(defn epoch-ms->timestamp-string
  ; @param (ms) n
  ;
  ; @example
  ;  (time/epoch-ms->timestamp-string 1640800860000)
  ;  =>
  ;  "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n])
  ; TODO

(defn epoch-s->timestamp-string
  ; @param (s) n
  ;
  ; @example
  ;  (time/epoch-s->timestamp-string 1640800860)
  ;  =>
  ;  "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n])
  ; TODO
